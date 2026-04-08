;
; Complete the 'sockMerchant' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER n
;  2. INTEGER_ARRAY ar
;

(defmacro reduce* [init [x coll] & body]
  (let [acc-names (map name (keys init))
        acc-syms  (map symbol acc-names)]
    `(reduce (fn [{:keys [~@acc-syms]} ~x]
               ~@body)
             ~init
             ~coll)))

(defn sockMerchant [n ar]
  (->

   (reduce* {:num-pairs 0 :counts #{}}
            [a ar]

     (if (contains? counts a)
       {:num-pairs (inc num-pairs) :counts (disj counts a)}
       {:num-pairs num-pairs :counts (conj counts a)}))

   :num-pairs))

