;
; Complete the 'encryption' function below.
;
; The function is expected to return a STRING.
; The function accepts STRING s as parameter.
;

(require '[clojure.string :as str])

(defn subs* [s i width]
  (subs s i (min (+ i width) (count s))))

(defn remove-spaces [s]
  (str/replace s #" " ""))

(defn get-width [s]
  (let [n (count s)]

    (-> n
        Math/sqrt
        Math/ceil
        long)))

(defn pad [row width]
  (as->
   (- width (count row)) $
   (repeat $ "")
   (into row $)))

(defn get-rows [s width]
  (let [n (count s)]

   (for [i (range 0 n width)]
     (-> (subs* s i (+ i width))
         vec
         (pad width)))))

(defn get-columns [rows]
  (apply map vector rows))

(defn join-columns [columns]
  (->>
   (for [column columns] (apply str column))
   (clojure.string/join " ")))

(defn encryption [s]
  (let [width (get-width (remove-spaces s))
        rows (get-rows (remove-spaces s) width)
        columns (get-columns rows)
        encoded (join-columns columns)]

    encoded))
