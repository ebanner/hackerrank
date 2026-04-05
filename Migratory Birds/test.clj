(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (migratoryBirds [1 4 4 4 5 3])
         4))

  (is (= (migratoryBirds [1 2 3 4 5 4 3 2 1 3 4])
         3)))

(run-tests)
