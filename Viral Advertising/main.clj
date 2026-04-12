;
; Complete the 'viralAdvertising' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER n as parameter.
;

(defmacro reduce* [[acc init x coll] & body]
  `(reduce (fn [~acc ~x] ~@body) ~init ~coll))

(defn viralAdvertising [n]
  (reduce* [num-likes 5
            i (range (dec n))]

    (->
     (quot num-likes 2)
     (* 3))))
