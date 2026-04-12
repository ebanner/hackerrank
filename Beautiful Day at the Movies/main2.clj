;
; Complete the 'beautifulDays' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER i
;  2. INTEGER j
;  3. INTEGER k
;

(defn reversed [n]
  (loop [n n reversed-n 0]
    (if (zero? n)
      reversed-n
      (let [digit (rem n 10)]
        (recur (quot n 10) (+ (* reversed-n 10) digit))))))

(defn beautiful? [n k]
  (->
   (- n (reversed n))
   Math/abs
   (rem k)
   zero?))

(defn beautifulDays [i j k]
  (->>
   (range i (inc j))
   (filter #(beautiful? % k))
   count))
