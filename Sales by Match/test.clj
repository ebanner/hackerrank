(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (sockMerchant 9 [10 20 20 10 10 30 50 10 20])
         3)))

(run-tests)
