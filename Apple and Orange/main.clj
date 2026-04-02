;
; Complete the 'countApplesAndOranges' function below.
;
; The function accepts following parameters:
;  1. INTEGER s
;  2. INTEGER t
;  3. INTEGER a
;  4. INTEGER b
;  5. INTEGER_ARRAY apples
;  6. INTEGER_ARRAY oranges
;

(def ≤ <=)

(defmacro reduce* [[acc init x coll] & body]
  `(reduce (fn [~acc ~x] ~@body) ~init ~coll))

(defn get-apple-destinations [apples a]
  (for [x apples] (+ x a)))

(defn get-orange-destinations [oranges b]
  (for [x oranges] (+ x b)))

(defn countApplesAndOranges [s t a b apples oranges]
  (let [num-apples
        (reduce* [num-apples 0
                  apple-destination (get-apple-destinations apples a)]

          (if (≤ s apple-destination t)
            (inc num-apples)
            num-apples))

        num-oranges
        (reduce* [num-oranges 0
                  orange-destination (get-orange-destinations oranges b)]

          (if (≤ s orange-destination t)
            (inc num-oranges)
            num-oranges))]

    [num-apples num-oranges]))

(countApplesAndOranges 7 11 5 15 [-2 2 1] [5 -6])
