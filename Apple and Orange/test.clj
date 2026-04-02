(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (countApplesAndOranges 7 11 5 15 [-2 2 1] [5 -6])
         [1 1])))

(run-tests)
