(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn gcf [num1 num2]
  (loop [a num1 b num2]
    (if (= b 0)
      a
      (recur b (mod a b)))))
	  
(defn lcm [num1 num2]
  (* (/ num1 (gcf num1 num2)) num2))
  
(defn euler5 [n]
  (reduce lcm (range 1 (+ n 1))))
  
(println (euler5 (Integer/valueOf (process-file (first *command-line-args*)))))