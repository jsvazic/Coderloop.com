(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    (Integer/parseInt (.trim (.readLine br)))))

(defn divisible-by-3-or-5? [num] 
  (or (== (mod num 3) 0)(== (mod num 5) 0)))

(println (reduce + (filter divisible-by-3-or-5? (range (process-file (first *command-line-args*))))))
