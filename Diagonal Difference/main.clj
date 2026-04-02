;
; Complete the 'diagonalDifference' function below.
;
; The function is expected to return an INTEGER.
; The function accepts 2D_INTEGER_ARRAY arr as parameter.
;

(defn get-diagonals [grid]
  (def N (count grid))

  [(for [i (range N)] ((grid i) i))
   (for [i (range N)] ((grid i) (- N i 1)))])

(defn diagonalDifference [arr]
  (let [[d1 d2] (get-diagonals arr)]
    (-> (- (reduce + d1) (reduce + d2))
        Math/abs)))
