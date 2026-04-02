(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (reverseArray [1 2 3])
         [3 2 1])))

(run-tests)
