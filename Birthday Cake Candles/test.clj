(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (birthdayCakeCandles [3 2 1 3])
         2)))

(run-tests)
