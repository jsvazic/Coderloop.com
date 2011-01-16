(import '(java.io BufferedReader FileReader))
(defn read-number-from-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    (Integer/parseInt (.trim (.readLine br)))))

(defn process-num [x]
  (cond
    (= 0 (mod x 21)) "Shazoo!"
    (= 0 (mod x 3)) "Moo"
	(= 0 (mod x 7)) "Muu"
	))

(defn shazoo [x]
  (let [numbers (range 1 (+ x 1))]
    (filter #(not= nil %) (map process-num numbers))))
	
(doall (map println (shazoo (read-number-from-file (first *command-line-args*)))))