;
; Complete the 'plusMinus' function below.
;
; The function accepts INTEGER_ARRAY arr as parameter.
;

(defmacro reduce* [init [x coll] & body]
  (let [acc-names (map name (keys init))
        acc-syms  (map symbol acc-names)]
    `(reduce (fn [{:keys [~@acc-syms]} ~x]
               ~@body)
             ~init
             ~coll)))

(defn get-counts [arr]
  (reduce* {:P 0 :N 0 :Z 0}
           [a arr]
   (cond
     (pos? a) {:P (inc P) :N N :Z Z}
     (neg? a) {:P P :N (inc N) :Z Z}
     (zero? a) {:P P :N N :Z (inc Z)})))

(defn print6 [x]
  (println (format "%.6f" x)))

(defn plusMinus [arr]
  (def n (count arr))

  (let [{:keys [P N Z]} (get-counts arr)]
    (print6 (/ (double P) n))
    (print6 (/ (double N) n))
    (print6 (/ (double Z) n))))
