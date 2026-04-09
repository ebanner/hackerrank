;
; Complete the 'pickingNumbers' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER_ARRAY a as parameter.
;

(defmacro reduce* [[acc init x coll] & body]
  `(reduce (fn [~acc ~x] ~@body) ~init ~coll))

(defn get-bitmap [A]
  (reduce* [bitmap (into [] (repeat 100 0))
            a A]
    (update bitmap a inc)))

(defn get-count [bitmap [i j]]
  (let [window (subvec bitmap i (inc j))]

    (reduce + window)))

(defn pickingNumbers [A]
  (let [N 100
        bitmap (get-bitmap A)]

    (reduce* [max-subarray-length 0
              [i j] (map vector (range (dec N)) (range 1 N))]

      (max (get-count bitmap [i j]) max-subarray-length))))
