;
; Complete the getMoneySpent function below.
;

(defmacro reduce* [[acc init x coll] & body]
  `(reduce (fn [~acc ~x] ~@body) ~init ~coll))

(defn getMoneySpent [keyboards drives b]
  (reduce* [max-price -1
            [keyboard drive] (for [keyboard keyboards drive drives] [keyboard drive])]

    (let [price (+ keyboard drive)]

      (if (<= price b)
        (max price max-price)
        max-price))))
