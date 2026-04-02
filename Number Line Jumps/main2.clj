;
; Complete the 'kangaroo' function below.
;
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. INTEGER x1
;  2. INTEGER v1
;  3. INTEGER x2
;  4. INTEGER v2
;

(defmacro defclause [name args pred & body]
  (let [clauses-sym (symbol (str name "-clauses"))]
    `(do
       (defonce ~clauses-sym (atom []))
       (defonce ~name
         (fn [& args#]
           (let [clauses# @~clauses-sym]
             (loop [[c# & rest#] clauses#]
               (when-not c#
                 (throw (ex-info "No matching clause" {:args args#})))
               (let [pred# (:pred c#)
                     body# (:body c#)]
                 (if (apply pred# args#)
                   (apply body# args#)
                   (recur rest#)))))))
       (swap! ~clauses-sym
              conj
              {:pred (fn ~(vec args) ~pred)
               :body (fn ~(vec args) ~@body)}))))

(defclause kangaroo [_ v1 _ v2] (>= v2 v1)
  "NO")

(defclause kangaroo [x1 v1 x2 v2] true
  (loop [x1 x1
         x2 x2]

    (cond
      (= x1 x2) "YES"
      (> x1 x2) "NO"
      :else (recur (+ x1 v1) (+ x2 v2)))))
