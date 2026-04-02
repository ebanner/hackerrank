;
; Complete the 'birthdayCakeCandles' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER_ARRAY candles as parameter.
;

(defn get-tallest [candles]
  (apply max candles))

(defn birthdayCakeCandles [candles]
  (let [tallest (get-tallest candles)]
    (->
     (for [candle candles :when (= candle tallest)] candle)
     count)))
