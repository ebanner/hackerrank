(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (pageCount 6 2)
         1)))

(deftest t2
  (is (= (pageCount 37455 29835)
         3810)))

(run-tests)
