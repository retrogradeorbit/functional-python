(ns builder.core
  (:require [hiccup.core :refer [html]])
  (:gen-class))

(declare page-head)
(declare page-source)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "reveal/reveal.js-3.2.0/presentation.html"
   (html [:html page-head page-source])))

;;
;; source
;;
(def page-head
  [:head
   [:meta {:charset "utf-8"}]
   [:title "Functional Python"]
   [:meta {:name "description" :content "What do functional languages teach us? How does learning them change the way we write Python"}]
   [:meta {:name "apple-mobile-web-app-capable" :content "yes"}]
   [:meta {:name "apple-mobile-web-app-status-bar-style" :content "black-translucent"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui"}]
   [:link {:rel "stylesheet" :href "css/reveal.css"}]
   [:link#theme {:rel "stylesheet" :href "css/theme/black.css"}]
   [:link {:rel "stylesheet" :href "lib/css/zenburn.css"}]
   [:script
    "
var link = document.createElement( 'link' );
link.rel = 'stylesheet';
link.type = 'text/css';
link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
document.getElementsByTagName( 'head' )[0].appendChild( link );"]])


(def page-source
  [:body
   [:div.reveal
    [:div.slides
     [:section
      [:h1 "Functional Python"]
      [:p "What do functional languages teach us? How does learning one change the way we write Python?"]
      [:p [:small "Created by " [:a "Crispin Wellington"]]]
      [:aside.notes
       [:ul
        [:li "Who am I?"]
        [:li "Work @ SignIQ."]
        [:li "Enjoy coding in GameJams."]
        [:li "Ideas of FP can be quite 'challenging'"]]
       ]
      ]

     [:section
      [:h1 "Empty Your Cup"]
      [:img {:src "./img/teacup.jpg"
             :width "500px"}]
      [:p.fragment.fade-in "A university professor went to visit a famous Zen monk. While the monk quietly served tea, the professor talked about Zen. The monk poured the visitor's cup to the brim, and then kept pouring."]
      [:p.fragment.fade-in "The professor watched the overflowing cup until he could no longer restrain himself."]
      [:p.fragment.fade-in "“It's overfull! No more will go in!” the professor blurted."]
      [:p.fragment.fade-in "“You are like this cup,” the monk replied, “How can I show you Zen unless you first empty your cup.”"]
      ]

     (comment
       [:section
        [:blockquote "“Lisp is worth learning for the profound enlightenment experience you will have when you finally get it; that experience will make you a better programmer for the rest of your days, even if you never actually use Lisp itself a lot.”" [:br] "-- Eric S Raymond"]
        ]

       [:section
        [:h2 "So tell me, are you experienced?"]
        [:ul
         [:li "What is this" [:i "experience"] "he speaks of?"]
         [:li.fragment.fade-in "How has learning Lisp changed my Python programming"]
         [:li.fragment.fade-in "How can we improve Python to help us write functional programmes?"]]])

     [:section {:style "margin-top: -50px"}
      [:h2 "LISP"]
      [:p "Lisp is a " [:i "family"] " of languages recognised by their unique syntax, heavily influenced by lambda calculus and where source code is comprised of lists."]
      [:pre [:code.clojure
             "(println “Hello, world!”)
(print “What is your name? ”)
(let [name (read-line)]
    (println “Hello, ” name “! My name is John McCarthy.”))
"]]
      [:p "Lisp was invented by " [:a "John McCarthy"] " in " [:i "1958"] ". It is a pioneering language that invented things like:"]
      [:ul
       [:li "tree data structures"]
       [:li "dynamic typing"]
       [:li "recursion"]
       [:li "garbage collection"]
       [:li "higher-order functions"]
       [:li "homoiconicity"]
       [:li "macros"]]
      [:p [:a "Clojure"] " is a modern Lisp variant written by " [:a "Rich Hickey"] " that produces compiled artifacts that run on the Java Virtual Machine, the Common Language Runtime or on Javascript engines, including in the browser."]]

     [:section
      [:h2 "Characteristics of Clojure"]
      [:ul
       [:li.fragment.grow "Functional"]
       [:li.fragment.grow "Immutable"]
       [:li "Lazy"]
       [:li "Persistent"]
       [:li "Dynamic Typing"]
       [:li "Software Transactional Memory"]
       [:li "Effortless Parallelism and Concurrency"]
       [:li "Destructuring"]
       [:li "Polymorphic"]
       [:li "Strong Interoperability"]
       [:li "Contracts (from Eiffel)"]
       [:li "Powerful async constructs (from Go)"]
       [:li "Logic programming (from Prolog)"]
       [:li "Pattern matching (from ML)"]
       [:li "Lisp macros"]]]

     [:section
      [:section
       [:h2 "What is Functional Programming?"]
       [:p.fragment.appear "Functional programming is programming in a style that favours (pure) functions over other constructs."]]

      [:section
       [:h2 "What is a function?"]
       [:blockquote.fragment.appear "In mathematics, a function is a relation between a set of inputs and a set of permissible outputs with the property that each input is related to exactly one output."
        [:br] "-- Wikipedia"]
       [:img.fragment.appear {:src "function.svg" :width "800px" :style "background-color: white" }]
       [:aside.notes
        [:ul
         [:li "In this case, a value in Set A called x is mapped to its resultant value from Set B, f(x)"]
         [:li "and the value from A, 'y' is mapped to its resultant f(y)"]
         [:li "Set A and Set B could be anything."]
         [:li "Set A could be the Set of Real Numbers, and Set B also."]
         [:li "Or Set A could be the Set of possible strings, and set B the set of positive integers"]
         [:li "Or Set A could be the Set of 2 dimensional vectors and set B could be the Set possible lists"]]]]

      [:section
       [:h3 "Example Functions"]
       [:p "A simple function that maps a number to its square:"]
       [:p "In Haskell:"]
       [:pre [:code {:data-trim ""}
              "
square :: Int -> Int
square x = x * x
"]]
       [:p]
       [:p "In Clojure:"]
       [:pre [:code {:data-trim ""}
              "
(defn square [x]
  (* x x))
"]]

       [:p]
       [:p "In Python:"]
       [:pre [:code {:data-trim ""}
              "
def square(x):
    return x*x
"]]]

      [:section
       [:h3 "Pure Functions"]
       [:p "A function is " [:i "pure"] " if both:"]
       [:blockquote #_ {:style "font-size: 26"} "The function always evaluates to the same output value given the same values for its input arguments."
        #_ (The function result value cannot
                depend on any hidden information or state that may change as program
                execution proceeds or between different executions of the program,
                nor can it depend on any external input from I/O devices.)
        ]
       [:p "and:"]
       [:blockquote.fragment.appear #_ {:style "font-size: 26"} "Evaluation of the result does not cause any semantically
  observable side effect or output, such as mutation of mutable
  objects or output to I/O devices."]
       [:p]
       [:p.fragment.appear "In functional programming we want to use " [:i "pure"]
        " functions. ie. They take " [:i "values"]
        ", only operate on those parameters, don't mutate state, and return a "
        [:i "value"]
        " to the caller"]]

      [:section
       [:h3 "Pure or impure?"]
       [:p
        [:table {:style "color: white;"}
         [:thead [:tr [:th "Function Call"] [:th "Pure or Impure?"]]]
         [:tbody
          [:tr [:td.fragment.appear "+, -, /, *"] [:td.fragment.appear "Pure"]]
          [:tr [:td.fragment.appear "len(mystring)"] [:td.fragment.appear "Pure"]]
          [:tr [:td.fragment.appear "math.sqrt(mynum)"] [:td.fragment.appear "Pure"]]
          [:tr [:td.fragment.appear "random()"] [:td.fragment.appear "Impure"]]
          [:tr [:td.fragment.appear "sorted(mylist)"] [:td.fragment.appear "Pure"]]
          [:tr [:td.fragment.appear "mylist.sort()"] [:td.fragment.appear "Impure"]]
          [:tr [:td.fragment.appear "myfile.read()"] [:td.fragment.appear "Impure"]]
          [:tr [:td.fragment.appear "datetime.today()"] [:td.fragment.appear "Impure"]]
          [:tr [:td.fragment.appear "mylist.append(myval)"] [:td.fragment.appear "Impure"]]
          [:tr [:td.fragment.appear "list1 + list2"] [:td.fragment.appear "Pure"]]]]]]]

     [:section
      [:section
       [:h2 "Map"]
       [:p "Takes a function and a collection. Evaluates the function, passing in every item in the collection. Takes all the return values of those calls and returns them in a new collection."]
       [:pre [:code.python
              "map(f, coll)

[f(x) for x in coll]

{f(x):g(x) for x in coll}

{f(k):g(v) for k,v in coll.items()}

(f(x) for x in coll)
"]]]

      [:section
       [:h2 "Example Map"]
       [:p "Imperative code like this:"]
       [:pre [:code.python
              "output = []
for word in ['this', 'is', 'a', 'list', 'of', 'words']:
    output.append(len(word))
print output

output = {}
for word in ['this', 'is', 'a', 'list', 'of', 'words']:
    output[word] = len(word)
print output
"
              ]]
       [:p "Can be expressed functionally like this:"]
       [:pre [:code.python
              ">>> map(len, ['this', 'is', 'a', 'list', 'of', 'words'])
[4, 2, 1, 4, 2, 5]

>>> [len(word) for word in ['this', 'is', 'a', 'list', 'of', 'words']]
[4, 2, 1, 4, 2, 5]

>>> {word:len(word) for word in ['this', 'is', 'a', 'list', 'of', 'words']}
{'a': 1, 'this': 4, 'of': 2, 'is': 2, 'list': 4, 'words': 5}
"]]]]

     [:section
      [:section
       [:h2 "Filter"]
       [:p "Takes a collection and returns a new collection containing only those items from the first that pass some test."]
       [:pre [:code.python
              "filter(pred, coll)

[x for x in coll if x=='foo']

[x for x in coll if pred(x)]

{k:v for k,v in coll.items() if pred(k,v)}
"]]]

      [:section
       [:h2 "Example Filter"]
       [:p "Imperative code like this:"]
       [:pre [:code.python
              "output = []
for word in ['this', 'is', 'a', 'list', 'of', 'words']:
    if len(word)==4:
        output.append(word)
print output
"
              ]]
       [:p "Can be expressed functionally like this:"]
       [:pre [:code.python
              ">>> filter(lambda word: len(word)==4, ['this', 'is', 'a', 'list', 'of', 'words'])
['this', 'list']

>>> [word for word in ['this', 'is', 'a', 'list', 'of', 'words'] if len(word)==4]
['this', 'list']
"]]]]

     [:section
      [:section
       [:h2 "Reduce"]
       [:p "Consume all the items in a collection by passing them in turn to a function. That function "
        "gets passed the item being consumed, as well as the result of the last function call performed by reduce. "
        "In this way a collection of items are fed through a function that reduces them to one output value. "]
       [:p "Reduce optionally takes an initial argument that will be used in the first call to the function."
        " If this is not specified, the first call is passed two items from the start of the collection."]
       [:pre [:code.python
              "def func(accumulator, element):
    return ...

reduce(func, coll)

reduce(func, coll, initial_value)"]]
       [:aside.notes
        [:p "fold. foldl. foldr"]]
       ]

      [:section

       [:pre [:code.python
              ">>> def f(a,b):
...   print \"f called with:\", a, b
...   return a+b
...
>>> reduce(f, range(10))
f called with: 0 1
f called with: 1 2
f called with: 3 3
f called with: 6 4
f called with: 10 5
f called with: 15 6
f called with: 21 7
f called with: 28 8
f called with: 36 9
45
"
              ]]]

      [:section
       [:pre [:code.python
              ">>> def reverser(a,b):
...     print \"reverser called with:\", a, b
...     return [b] + a
...
>>> reduce(reverser, [1, 4, 9, 16, 25], [])
reverser called with: [] 1
reverser called with: [1] 4
reverser called with: [4, 1] 9
reverser called with: [9, 4, 1] 16
reverser called with: [16, 9, 4, 1] 25
[25, 16, 9, 4, 1]
"

              ]]]

      [:section
       [:pre [:code.python
              ">>> coll = [-20, 10, 100, -43, 35]
>>> reduce(lambda a,b: a if a < b else b, coll)
-43
>>> reduce(lambda a,b: a if a > b else b, coll)
100
>>> reduce(min, coll)
-43
>>> reduce(max, coll)
100
>>> min(coll)
-43
>>> max(coll)
100
"


              ]]]]

     [:section
      [:section
       [:h2 "Higer Order Functions"]
       [:p "A function is said to be of a “higher order” if it takes another function as one of its aguments, or returns a function as part of it's result, or both."]]

      [:section
       [:h2 "Python Examples"]
       [:pre [:code.python
              "map(function, coll)

filter(function, coll)

reduce(function, coll)
"]]

       ]

      [:section
       [:h2 "Decorators"]
       [:p "Python decorators are functions. They get invoked during compilation and into them is passed the function that is to be decorated. They return a new function that is to replace the old one in the namespace."]

       [:pre
        [:code.python {:style "max-height: inherit;"}
         "def debug(fn):
    def new_func(*args, **kwargs):
        result = fn(*args, **kwargs)
        print \"{} called with args: {} and kwargs: {} and returned: {}\".format(fn.__name__, args, kwargs, result)
        return result
    return new_func

@debug
def solve_quadratic(a, b, c):
    sqrt_b2_minus_4ac = math.sqrt(
        b * b - 4 * a * c
    )
    return (
        (- b + sqrt_b2_minus_4ac) / (2 * a),
        (- b - sqrt_b2_minus_4ac) / (2 * a)
    )

result = solve_quadratic(10, 2, 4)
"]]
       [:p "running it looks like:"]
       [:pre
        [:code.bash {:style "max-height: inherit;"}
         "$ python test.py
solve_quadratic called with args: (10, 2, -4) and kwargs: {} and returned: (0.5403124237432848, -0.7403124237432849)
result = (0.5403124237432848, -0.7403124237432849)
"]]
       [:aside.notes
        [:p "talk a bit about function composition?"]]
       ]]

     [:section
      [:h1 "lets code..."]
      ]

     [:section
      [:h2 "Immutability"]
      [:p "Q: If I can't change anything, how can I " [:i "do"] " anything? "
       "How can I model change at all?"]
      [:p.fragment.appear "A: By building new things that are the same as the old things, but with slight differences"]
      [:br]
      [:p.fragment.appear "We call these immutable things " [:a "Values"] "."]
      ]

     [:section
      [:section
       [:h2 "Values"]
       [:p "A particular magnitude, number or amount. "
        "A Precise meaning or significance."]
       [:br]
       [:ul
        [:li.fragment.appear "Values never change (immutable)"]
        [:li.fragment.appear "Values can be perceived and compared to other values"]
        [:li.fragment.appear "Equality and comparability are the basis for logic"]
        [:li.fragment.appear "Semantically transparent"
         [:ul
          [:li.fragment.appear "Don't " [:i "need"] " methods"]
          [:li.fragment.appear "I can send you values without code and you are fine"]
          [:li.fragment.appear "they are not operationally defined"]
          [:li.fragment.appear "There can't be any code overhead that is required to understand meaning, equality or comparability."]]]
        [:li.fragment.appear "Can be abstracted (collections)"]
        ]]

      [:section
       [:h2 "What are values in Python?"]
       [:p.fragment.appear "Real numbers? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "None? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "Booleans? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "Tuple? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "Datetime? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "String? " [:span.fragment.appear "yes"]]
       [:p.fragment.appear "List? " [:span.fragment.appear "no"]]
       [:p.fragment.appear "Dictionary? " [:span.fragment.appear "no"]]
       [:p.fragment.appear "Set? " [:span.fragment.appear "no"]]
       [:p.fragment.appear "Generator instances? " [:span.fragment.appear "no"]]
       [:p.fragment.appear "Class instance? " [:span.fragment.appear "depends (usually no)"]]
       [:p.fragment.appear "Class? " [:span.fragment.appear "no"]]
       [:p.fragment.appear "Module? " [:span.fragment.appear "no"]]

       ]]

     [:section
      [:section
       [:h2 "The Many Benefits of Values"]]

      [:section
       [:h2 "Values aggregate"]
       [:ul
        [:li.fragment.appear "Immutable collections of values are values"]
        [:li.fragment.appear "All benefits apply in compositions"]]
       [:aside.notes
        [:p "Composite Objects? Group a number of objects together into another."]
        [:ul
         [:li "What properties can you ascertain about the whole?"]
         [:li "You start again defining the interface for the aggregate"]
         [:li "even with clone/copy/lock policy for each part"]
         [:li "Combining them you no longer have a clone/copy/lock policy"]
         [:li "Need a new operational interface for the aggregate"]
         [:li "Objects don't compose"]]]]

      [:section
       [:h2 "Values can be Freely Shared"]
       [:ul
        [:li.fragment.appear "Sharing is aliasing"]
        [:li.fragment.appear "Safe"]
        [:li.fragment.appear "Incremental change is cheap (persistent structures)"]]
       [:aside.notes
        [:ul
         [:li "Objects? Defensive copying. Locking."]]]]

      [:section
       [:h2 "Values are Easy to Fabricate"]
       [:ul
        [:li.fragment.appear "Anything can create them easily"]
        [:li.fragment.appear "Easy for tests to create"]
        [:li.fragment.appear "Easy to dry run or simulate"]]
       [:aside.notes
        [:ul
         [:li "Object?"]
         [:li "You must match or emulate some kind of operational interface"]
         [:li "Mocks... inside mocks inside mocks"]]]]

      [:section
       [:h2 "Values are Reproducible"]
       [:ul
        [:li.fragment.appear "Stable: operations are reproducible."]
        [:li.fragment.appear "Testing"]
        [:li.fragment.appear "Debugging: reproduce problems without state"]]
       [:aside.notes
        [:ul
         [:li "Stable: operations are reproducible means:"]
         [:li "Same input, same output"]
         [:li "Objects?"]
         [:li "Must establish the matching state"]
         [:li "Must recreate the state when the problem occured"]
         [:li "Global state problems"]
         [:li "Call a() then b() when the sun is at its zenith on tuesday"]]]]

      [:section
       [:h2 "Values are Language Independent"]
       [:ul
        [:li.fragment.appear "Any language can create values"]
        [:li.fragment.appear "Any language can receive values"]]
       [:aside.notes
        [:ul
         [:li "examples: html, json, xml."]
         [:li "Objects?"]
         [:li "defined by the language constructs (their methods)"]
         [:li "completely bound to the language of implementaion"]
         [:li "to break out need to code interfaces"]
         [:li "proxies, remotes, SOAP, REST interface generation"]]]]

      #_ [:section
       [:h2 "Values thwart imperativeness"]
       [:ul
        [:li.fragment.appear "Refuse to help you program imperatively"]
        [:li.fragment.appear "This is a feature, not a limitation"]]]

      [:section
       [:h2 "Values are generic"]
       [:ul
        [:li.fragment.appear "Representations of basic values in any language"]
        [:li.fragment.appear "Very small number of basic abstractions (less than 10)"]]
       [:aside.notes
        [:ul
         [:li "less than 10: numbers, strings, booleans, none, vectors, hashmaps, sets"]
         [:li "Objects? Interface is too specific. Means more and more code. Poor reuse"]
         [:li "how many large OOP systems can you do with less than 10 classes"]
         [:li "Every new thing needs a new class. Where's the reuse?"]
         [:li "Q: If I have a person class, and you have a person class, in their own namespaces, and they both have 'name', 'address' and 'email' what can we do with these two things?"]
         [:li "A: Nothing! Semantically identical. same names. completely uninteroperable."]
         [:li "TOO SPECIFIC"]
         ]]
       ]

      [:section
       [:h2 "Values make great interfaces"]
       [:p "If your code is based on values you can:"]
       [:ul
        [:li.fragment.appear "Move it"]
        [:li.fragment.appear "Port it"]
        [:li.fragment.appear "Enqueue it"]
        ]
       [:aside.notes
        [:ul
         [:li "Imagine a system with component parts. What happens if you want to move one out?"]
         [:li "out of resources?"]
         [:li "another team"]
         [:li "another language"]
         [:li "Objects... you're stuck."]
         [:li "In the large, we know this. We don't build objects over the wire"]
         [:li "we throw it all out when we program in the small"]]]
       ]

      ]

     [:section
      [:section
       [:h2 "Programming with Values"]]

      [:section
       [:h2 "Sending Values"]
       [:ul
        [:li.fragment.appear "Reference is all you need to pass"]
        [:li.fragment.appear "Cheap"]
        [:li.fragment.appear "Safe and worry free"]]
       [:aside.notes
        [:ul
         [:li "passing a reference to a mutable thing, what information have you conveyed? Only its location"]
         [:li "Q: Who is the president of the United States at this point in time?"]
         [:li "A: The pigeon hole over there third from the left."]
         [:li "Sending information with places is hard."]
         [:li "Basically need to convert it to a value"]
         [:li "Values rule over the network. eg HTTP. Imagine an OOP protocol"]]]
       ]

      [:section
       [:h2 "Perceiving Values"]
       [:ul
        [:li.fragment.appear "A reference is perception"]
        [:li.fragment.appear "Snapshots"]]
       [:aside.notes
        [:ul
         [:li "How do you atomically percieve a coherent value of an object with multiple getters?"]
         [:li "MASSIVE concurrency problem."]
         [:li "also a single threaded problem."]
         [:li "Copying. Cloning. Locking. Made over and over and over again."]
         [:li "basically need to create consistent values"]]]
       ]

      [:section
       [:h2 "Remembering Values"]
       [:ul
        [:li.fragment.appear "Aliasing is remembering"]
        [:li.fragment.appear "Forgetting is garbage collection"]]
       [:aside.notes
        [:ul
         [:li "Objects? Copy. Deep copy."]]]
       ]

      [:section
       [:h2 "Co-ordinating Values"]
       [:ul
        [:li.fragment.appear "No need for locks"]
        [:li.fragment.appear "No need for transactions"]
        [:li.fragment.appear "Concurrency FTW!"]]
       [:aside.notes
        [:ul
         [:li "Objects? Locks. Transactions."]
         [:li "Difficult to get right. Even harder to prove it's right"]
         [:li "Often wrong: deadlocks, race conditions."]]]
       ]

      [:section
       [:h2 "Locating Values"]
       [:ul
        [:li.fragment.appear "Only one copy needed in RAM"]
        [:li.fragment.appear "Memoizable"]
        [:li.fragment.appear "Cachable"]
        [:li.fragment.appear "Distributable"]
        ]
       ]]

     [:section
      [:h1 "lets code..."]
      ]

     [:section
      [:h1 "Some useful libraries"]
      [:ul
       [:li "Python functools " [:a "Python built in"]]
       [:li "PyToolz " [:a "toolz.readthedocs.org"]]
       [:li "Pyrsistent " [:a "pyrsistent.readthedocs.org"]]]
      ]

     [:section
      [:h2 "The Future"]
      [:blockquote.fragment.appear "If you could design a language from scatch that didn’t need a GIL you would probably design a language without mutable objects. Or you’d limit the mutability to a small number of specific object types rather than making pretty much everything mutable, from modules to classes to instances to dictionaries to lists."
       [:br] "-- " [:a "Guido van Rossum "] "(Europython 2015 keynote)"]

      ;; https://www.youtube.com/watch?v=bp3mCgrdMxU#t=34m30s

      [:blockquote.fragment.appear "That would not be Python"
       [:br] "-- " [:a "Someone in the Audience "] "[Shouting]"]

      [:blockquote.fragment.appear "You’re taking the words right out of my mouth"
       [:br] "-- " [:a "Guido van Rossum"]]]

     #_ [:section
      [:h2 "The Future"]
      [:blockquote.fragment.appear "I don't know what the default programming language will be in 2020, but I garauntee that immutibility will be the default in that language."
       [:br] "-- Stuart Halloway"]]

     [:section
      [:h2 "A Final Thought"]
      [:blockquote.fragment.appear "You cannot step in the same river twice, for you are not the same person and it is not the same river."
       [:br] "-- " [:a "Heraclitus of Ephesus "] "(c. 535 - c. 475 BCE)"]
      [:br]
      [:blockquote.fragment.appear "We love this idea of objects, like there’s this thing that changes. There’s no river. There’s water there at one point-in-time. And another point-in-time, there’s other water there. River... it’s all in here [points at head]"
       [:br] "-- " [:a "Rich Hickey"]
       ]]]
    ]

   [:script {:src "lib/js/head.min.js"}]
   [:script {:src "js/reveal.js"}]
   [:script "	// Full list of configuration options available at:
			// https://github.com/hakimel/reveal.js#configuration
			Reveal.initialize({
				controls: true,
				progress: true,
				history: true,
				center: true,
                                keyboard: true,

                                width: 1600,
                                height: 960,
                                minScale: 0.1,
                                maxScale: 1.0,

				transition: 'slide', // none/fade/slide/convex/concave/zoom

				// Optional reveal.js plugins
				dependencies: [
					{ src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
					{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
					{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
					{ src: 'plugin/highlight/highlight.js', async: true, condition: function() { return !!document.querySelector( 'pre code' ); }, callback: function() { hljs.initHighlightingOnLoad(); } },
					{ src: 'plugin/zoom-js/zoom.js', async: true },
					{ src: 'plugin/notes/notes.js', async: true }
				]
			});"]
   ])
