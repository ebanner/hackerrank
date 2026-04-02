;
; Complete the 'getTotalX' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER_ARRAY a
;  2. INTEGER_ARRAY b
;

(defn between? [n A B]
  (and
   (every? identity (for [a A] (zero? (mod n a))))
   (every? identity (for [b B] (zero? (mod b n))))))

(defn getTotalX [a b]
  (->
   (for [n (range (apply min a) (inc (apply max b)))
         :when (between? n a b)]
     n)
   (count)))
