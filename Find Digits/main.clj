;
; Complete the 'findDigits' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER n as parameter.
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

(defmacro for|sum [bindings pred]
  `(->>
    (for ~bindings (if ~pred 1 0))
    (reduce +)))

(defclause get-digits [n] (zero? n)
  [])

(defclause get-digits [n] true
  (let [digit (rem n 10)]

    (conj (get-digits (quot n 10))
          digit)))

(defn findDigits [n]
  (for|sum [d (get-digits n)]

    (when (pos? d)
      (zero? (rem n d)))))
