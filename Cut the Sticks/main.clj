;
; Complete the 'cutTheSticks' function below.
;
; The function is expected to return an INTEGER_ARRAY.
; The function accepts INTEGER_ARRAY arr as parameter.
;

(defmacro defclause [name args pred & body]
  (let [clauses-sym (symbol (str name "-clauses"))
        clause-key  (list 'quote pred)]
    `(do
       (defonce ~clauses-sym (atom {}))
       (def ~name
         (fn [& args#]
           (loop [[[_k# c#] & rest#] (seq @~clauses-sym)]
             (when-not c#
               (throw (ex-info "No matching clause" {:args args#})))
             (if (apply (:pred c#) args#)
               (apply (:body c#) args#)
               (recur rest#)))))
       (swap! ~clauses-sym assoc
              ~clause-key
              {:pred (fn ~(vec args) ~pred)
               :body (fn ~(vec args) ~@body)}))))

(defn cut-by [sticks short]
  (->>
   (for [stick sticks] (- stick short))
   (filter pos?)))

(defclause cut [sticks] (empty? sticks)
  '())

(defclause cut [sticks] true
  (let [cut-sticks
        (cut-by (rest sticks) (first sticks))]

    (cons (count sticks) (cut cut-sticks))))

(defn cutTheSticks [arr]
  (let [sticks (sort arr)]

   (cut sticks)))
