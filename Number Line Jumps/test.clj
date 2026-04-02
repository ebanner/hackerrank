(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (kangaroo 0 3 4 2)
         true))

  (is (= (kangaroo 0 2 5 3)
         true)))

(run-tests)
