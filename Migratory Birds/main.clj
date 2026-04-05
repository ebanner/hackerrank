;
; Complete the 'migratoryBirds' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER_ARRAY arr as parameter.
;

(defmacro reduce* [[acc init x coll] & body]
  `(reduce (fn [~acc ~x] ~@body) ~init ~coll))

(defn get-counts [arr]
  (reduce* [counts {}
            a arr]
    (update counts a (fnil inc 0))))

(defn migratoryBirds [arr]
  (let [counts (get-counts arr)]

    (->> counts
         (sort-by key >)
         (apply max-key val)
         (key))))
