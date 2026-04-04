(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (birthday [1 2 1 3 2] 3 2)
         2)))

(deftest t2
  (is (= (birthday [1 1 1 1 1 1] 3 2)
         0)))

(deftest t3
  (is (= (birthday [4] 4 1)
         1)))

(run-tests)
