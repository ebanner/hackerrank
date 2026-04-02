(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (compareTriplets [5 6 7] [3 6 10])
         [1 1])))

(run-tests)
