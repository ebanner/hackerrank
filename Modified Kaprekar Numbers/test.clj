(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (kaprekarNumbers 1 100)
         [1 9 45 55 99])))

(run-tests)
