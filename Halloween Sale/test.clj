(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (howManyGames 20 3 6 70)
         5)))

(run-tests)
