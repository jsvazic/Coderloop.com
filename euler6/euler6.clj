(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn sum-of-squares [n]
  (reduce + (map #(* % %) (range 1 (+ n 1)))))
  
(defn square-of-sums [n]
  (reduce * (repeat 2 (reduce + (range 1 (+ n 1))))))
  
(let [n (Integer/valueOf (process-file (first *command-line-args*)))]
  (println (- (square-of-sums n) (sum-of-squares n))))