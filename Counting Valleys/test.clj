(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (countingValleys 8 "UDDDUDUU")
         1)))

(run-tests)



