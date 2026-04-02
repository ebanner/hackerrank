;
; Complete the 'compareTriplets' function below.
;
; The function is expected to return an INTEGER_ARRAY.
; The function accepts following parameters:
;  1. INTEGER_ARRAY a
;  2. INTEGER_ARRAY b
;

(defmacro reduce* [init [x coll] & body]
  (let [acc-names (map name (keys init))
        acc-syms  (map symbol acc-names)]
    `(reduce (fn [{:keys [~@acc-syms]} ~x]
               ~@body)
             ~init
             ~coll)))

(defn compareTriplets [a b]
  (->

   (reduce* {:alice-points 0 :bob-points 0}
       [[a b] (map vector a b)]
       (cond
         (> a b) {:alice-points (inc alice-points) :bob-points bob-points}
         (< a b) {:alice-points alice-points :bob-points (inc bob-points)}
         (= a b) {:alice-points alice-points :bob-points bob-points}))

   ((juxt :alice-points :bob-points))))

