;
; Complete the 'countingValleys' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER steps
;  2. STRING path
;

(defmacro reduce* [init [x coll] & body]
  (let [acc-names (map name (keys init))
        acc-syms  (map symbol acc-names)]
    `(reduce (fn [{:keys [~@acc-syms]} ~x]
               ~@body)
             ~init
             ~coll)))

(defn countingValleys [steps path]
  (->
   (reduce* {:num-valleys 0 :elevation 0}
            [p path]

     (cond (and (zero? elevation) (= p \D)) {:num-valleys (inc num-valleys) :elevation (dec elevation)}
           (= p \D) {:num-valleys num-valleys :elevation (dec elevation)}
           :else {:num-valleys num-valleys :elevation (inc elevation)}))

   :num-valleys))
