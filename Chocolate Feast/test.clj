(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (chocolateFeast 10 2 5)
         6)))

(deftest t2
  (is (= (chocolateFeast 12 4 4)
         3)))

(deftest t3
  (is (= (chocolateFeast 6 2 2)
         5)))

(run-tests)
