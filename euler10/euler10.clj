(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn primes [max]
  (let [enqueue (fn [sieve n factor]
                  (let [m (+ n (+ factor factor))]
                    (if (sieve m)
                      (recur sieve m factor)
                      (assoc sieve m factor))))
        next-sieve (fn [sieve candidate]
                     (if-let [factor (sieve candidate)]
                       (-> sieve
                         (dissoc candidate)
                         (enqueue candidate factor))
                       (enqueue sieve candidate candidate)))]
    (cons 2 (vals (reduce next-sieve {} (range 3 max 2))))))
	
(defn euler10 [n]
  (reduce + (primes n)))
  
(let [n (Integer/valueOf (process-file (first *command-line-args*)))]
  (println (euler10 n)))