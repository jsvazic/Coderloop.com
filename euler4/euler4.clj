(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn palindrome? [n] (= (str n) (apply str (reverse (str n)))))

(defn get-largest-palindrom [high low]
  (first (take 1 (for [x (range high low -1) :when (palindrome? (* high x))] [x]))))

(defn euler4 [digit-count]
  (let [min-num (dec (reduce * (repeat (dec digit-count) 10)))
        max-num (dec (reduce * (repeat digit-count 10)))]
    (loop [i max-num last-pal 1 max-pal 0]
      (if (< last-pal max-pal)
	    max-pal
	    (let [col (get-largest-palindrom i min-num)
	          new-last (if (empty? col) 1 (* i (first col)))
		      new-max (max max-pal new-last)]
	        (recur (dec i) new-last new-max))))))

(time (euler4 (Integer/valueOf (process-file (first *command-line-args*)))))