;
; Complete the 'squares' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER a
;  2. INTEGER b
;

(defn square? [n]
  (let [sqrt (Math/sqrt n)]

    (== sqrt (int sqrt))))

(defn squares [a b]
  (->>
   (range a (inc b))
   (filter square?)
   (count)))
