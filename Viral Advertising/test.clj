(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (viralAdvertising 3)
         9)))

(deftest t2
  (is (= (viralAdvertising 4)
         15)))

(run-tests)
