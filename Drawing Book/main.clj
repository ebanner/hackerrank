;
; Complete the 'pageCount' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER n
;  2. INTEGER p
;

(defn get-last-pages [n]
  (loop [pages-flipped 0
         pages [nil 1]]

    (if (some #{n} pages)
      pages
      (let [[_ p2] pages]
        (recur (inc pages-flipped)
               [(inc p2) (inc (inc p2))])))))

(defn pageCount [n p]
  (let [left
        (loop [pages-flipped 0
               pages [nil 1]]

          (if (some #{p} pages)
            pages-flipped
            (let [[_ p2] pages]
              (recur (inc pages-flipped)
                     [(inc p2) (inc (inc p2))]))))

        right
        (loop [pages-flipped 0
               pages (get-last-pages n)]

          (if (some #{p} pages)
            pages-flipped
            (let [[p1 _] pages]
              (recur (inc pages-flipped)
                     [(dec (dec p1)) (dec p1)]))))]

    (min left right)))
