(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (squares 3 9)
         2)))

(run-tests)
