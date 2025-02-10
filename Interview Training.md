***
**Timeline:**
- **technical interview training:** 21/01 - 28/02
- **start sending out applications:** 15/01
- **start organizing mocking interviews:** 15/01
- **start with interviews & behavioral stuff:** 15/01

**Objective: 15 problems per day**
- 21/01: 6
- 22/01: 3
- 23/01: 3
- 24/01: 1
- 28/01: 2
- 30/01: 6
- 03/02: 3
***

**Stuff for preparing Interviews.**
1) [[Java]]
2) [[Interview Training#Interview Best Practice and Tips|Interviews 101]]
3) [[Interview Training#Technical Stuff|Technical Stuff]] 
## Interview Best Practice and Tips
### What to do during your code interview
- **make a good self introduction at the start of the interview:**
	- **introduce yourself** in a few sentences under a minute or two: [[Interview Training#Self Introduction|self introduction]] 
	- sound happy
- **upon receiving the question, make clarifications:**
	- **do not jump into coding right away:** coding questions are unspecified and vague on purpose to allow the interviewer to gauge the candidate's attention to detail and carefulness. Ask at least 2-3 clarifying questions: 
	- **paraphrase and repeat the question back at the interviewer:** make sure you understand correctly what they are asking
	- **clarify assumptions:** use the algorithm [[Interview Training#algorithm cheatsheet|algorithm cheatsheet]] for common assumptions
		- can you modify the original array? 
		- how the input is stored?
		- ...
	- **clarify input value range**
	- **clarify input value format:** floating points? empty? null? duplicates?
	- **work through a simplified example to ensure you understood the question**
- **work out and optimize your approach with the interviewer:** do not jump into coding - interviewers expect there to be some time for a 2-way discussion (5-10 minutes, depends on how hard is the problem) on the correct approach to take for the question, including analysis of the time and space complexity
	- use [[Interview Training#Coding Interview Techniques|main techniques]] to find a good approach(es)
	- explain a few approaches that you could take at a high level (no implementation detail) and discuss the pros and cons of those approaches with the interviewer, as if he is your coworker 
	- state and explain the time and space complexity of your proposed approach(es): use big O notation and consider [[Interview Training#Optimize your solution|optimizations]] for your solution
	- agree on the most ideal approach and optimize it: identify repeated/duplicated/overlapping computations and reduce them via caching 
- **code out your solution while talking through it**
	- start coding after you have explained your approach and the interviewer has given you the green light
	- **explain what you are trying to achieve as you are writing:** use this to show mastery of the chosen language by comparing alternative language techniques
	- **write code at a reasonable speed so you can talk through it,** **but not too slow** as you have to answer all the questions
	- **write clean, neat and correct code that compiles and work**
	- **use meaningful names** 
	- **ask for permission to use trivial functions** without having to implement them (e.g., `min`, `max`, `filter`, ...)
	- **write in a modular fashion**, going from higher-level functions and breaking them down into smaller helper functions
	- **if you are cutting corners state that out loud and say what you would do instead** in a non-interview setting with no time constraints, e.g.: "under non-interview settings, I would write a regex to parse this string rather than using `split()` which may not cover certain edge cases"
	- **do not interrupt the interviewer** as they usually speak to give hints
	- **do not spend (much) time with comments**
	- **do not repeat yourself**
	- **do not copy and paste without double checking**
- **after coding, check your code and add test cases**
	- **once you are done coding do not announce that you are done:** interviewers expect you to start scanning for mistakes and adding test cases to improve your code. 
		- **scan your code for mistakes**
		- **brainstorm edge cases with the interviewer and add additional test cases**
		- step through your code with those test cases
		- **reiterate the time and space complexity of your code:** use this to remind yourself to spot issues within your code
		- **explain trade-offs** and how the code can be improved if given more time
- **at the end of the interview leave a good impressions**
	- **ask final questions** [[Interview Training#Final Questions to Ask|questions]] 
	- thank the interviewer 

After the interviewer record the questions for future reference, and send up a followup email or LinkedIn to your interviewer thanking them for their time.
### Self Introduction
**"Tell me about yourself"**
Interviewers want to work with candidates they like. Leave a good/deep impression and it will increase your chances of success.
**You need to tailor your self-introduction to the role and company you are applying for.** 

The question "tell me about yourself" actually means "tell me about your journey into tech. How did you get interested in coding, and why -this job- a good fit for you? How is that applicable to our role or company goals?" 
**Usually the interviewers want to hear things that are relevant to the job, not other stuff.**
#### Make an Elevator Pitch
You have to sell yourself, make you look good and do it fast: 
- **short:** limited time
- **direct:** get straight to the point 
- **attention-grabbing:** present your most attractive ideas

Here are some tips to develop a good elevator pitch for your software engineer self introduction:
1) **basic background information:** who you are, your professional/academic background, and what you do and have done, and what are your focus areas. Basically your resume, as fast as possible
2) **KISS: Keep It Simple and Sweet:** tell them some highlights from your favorite/most impressive projects (include some numbers if they're impressive) or challenges that you've overcome. Do not delve into the details, just tell them the executive summary, they might ask questions if they are interested. 
3) **why do they want you?** why are you a good fit? past experiences? already familiar with the tech stack? what unique talent(s) you have? 
4) **practice the pitch**

**Example:** Front End Engineer @ Meta
"Hi I'm XXX and I graduated from National University of Singapore in 2015 with a degree in Computer Science. My interests are in Front End Engineering and I love to create beautiful and performant products with delightful user experiences.

Back in school, I designed and built a web application, NUSMods which solves a huge problem of class and timetable planning every semester. It receives over a million pageviews a month and is used by over 40,000 NUS students and even some professors. It is built using a modern web technology stack - React, Redux, Jest, Babel, Flow, webpack and is mobile-responsive."

I'm interested in the Front End Engineer role at Meta because I have been using Meta Open Source Front End technologies for a while now and am inspired by Meta's mission and Open Source culture."
### Final Questions to Ask
Something you can always count on to happen at the end of your Software Engineer interview - both technical and non-technical rounds - is for the interviewer to ask you if you "**have any final questions?**".

**This is a rhetorical question: you have to ask something.**
Here there are some questions that might be useful. The <u>underlined questions</u> are the ones that usually make the interviewers more impressed. 
#### Questions to ask for knowing more about technical work
- <u>What are the engineering challenges that the company/team is facing?</u>
- <u>What has been the worst technical blunder that has happened in the recent past? How did you guys deal with it? What changes were implemented afterwards to make sure it didn't happen again?</u>
- <u>What is the most costly technical decision made early on that the company is living with now?</u>
- <u>What is the most fulfilling/exciting/technically complex project that you've worked on here so far?</u>
- <u>I do/don't have experience in domain X. How important is this for me to be able to succeed?</u>
- How do you evaluate new technologies? Who makes the final decisions?
- How do you know what to work on each day?
- How would you describe your engineering culture?
- How has your role changed since joining the company?
- What is your stack? What is the rationale for/story behind this specific stack?
- Do you tend to roll your own solutions more often or rely on third party tools? What's the rationale in a specific case?
- How does the engineering team balance resources between feature requests and engineering maintenance?
- What do you measure? What are your most important product metrics?
- How often have you moved teams? What made you join the team you're on right now? If you wanted to move teams, what would need to happen?
- What resources does the company have for new hires to study its product and processes? Are there specifications, requirements, documentation?
- How do you think my expertise would be relevant to this team? What unique value can I add?
#### Questions to ask for knowing more about the role
- <u>What qualities do you look out for when hiring for this role?</u>
- <u>What would be the most important problem you would want me to solve if I joined your team?</u>
- What does a typical day look like in this role?
- What are the strengths and weaknesses of the current team? What is being done to improve upon the weaknesses?
- What resources does the company have for new hires to study its product and processes? Are there specifications, requirements, documentation?
- What would I work on if I joined this team and who would I work most closely with?
#### Best questions to ask for knowing more culture and welfare
- <u>What is the most frustrating part about working here?</u>
- <u>What is unique about working at this company that you have not experienced elsewhere?</u>
- <u>What is something you wish were different about your job?</u>
- How is individual performance measured?
- What do you like about working here?
- What is your policy on working from home/remotely?
- What does the company do to nurture and train its employees?
- Does the company culture encourage entrepreneurship and creativity? Could you give me any specific examples?
#### Best questions to ask to know more about team leadership or management
These questions are suitable for asking Engineering Managers or senior level management, such as CEO, CTO, VPs and are especially useful for the Team Matching phase of Google interviews or post-offer calls that your recruiters set up with the various team managers.
- <u>How do you train/ramp up engineers who are new to the team?</u>
- <u>What does success look like for your team/project?</u>
- <u>What are the strengths and weaknesses of the current team? What is being done to improve upon the weaknesses?</u>
- <u>Can you tell me about a time you resolved an interpersonal conflict?</u>
- How did you become a manager?
- How do your engineers know what to work on each day?
- What is your team's biggest challenge right now?
- How do you measure individual performance?
- How often are 1:1s conducted?
- What is the current team composition like?
- What opportunities are available to switch roles? How does this work?
- Two senior team members disagree over a technical issue. How do you handle it?
- Have you managed a poor performer at some point in your career before? What did you do and how did it work?
- Where do you spend more of your time, high performers or low performers?
- Sometimes there's a trade-off between what's best for one of your team members and what's best for the team. Give an example of how you handled this and why.
- Give an example of a time you faced a difficult mentoring/coaching challenge. What did you do and why?
- What is your management philosophy?
- What is the role of data and metrics in managing a team like ours?
- What role does the manager play in making technical decisions?
- What is an example of a change you have made in the team that improved the team?
- What would be the most important problem you would want me to solve if I joined your team?
- What opportunities for growth will your team provide?
- What would I work on if I joined this team and who would I work most closely with?
#### Best questions to ask to know more about company direction
- <u>How does the company decide on what to work on next?</u>
- What assurance do you have that this company will be successful?
- Which companies are your main competitors and what differentiates your company?
- What are your highest priorities right now? For example, new features, new products, solidifying existing code, reducing operations overhead?
### How FAANG evaluates during a coding interview
The main **evaluation criteria** are: 
- **communication:** asking clarifying questions, explaining the approaches and their trade-off while thinking and writing code, etc.
- **problem solving:** understanding the problem and approach it rationally, accurately determine time and space complexity of each approach.
- **technical competency:** translating discussed solutions to working code with no struggle, clean and correct implementation with a strong knowledge of the chosen language.
- **testing:** ability to test the code against corner cases, self-correcting issues and making (micro)improvements on the code performance and/or clarity.
### Coding Interview Techniques
When given a coding interview question you should start by asking clarifying questions and discuss a few possible approaches with your interviewer. 
**Here is how to not get stuck in the discussion:**
1) **visualize the problem:** draw it out, play with the given data structures and try to visualize what needs to be done and what are the necessary step to reach the solution.
2) **come up with more examples:** what would be the solution with another example? how your theoretical solution handles them? 
3) **break down the question:** if the problem is large try to break it down to smaller problems, each handled by a function, and solve them separately. This is a good way to flex a rational way of thinking, even if you do not manage to implement all the functions
4) **apply common data structures and algorithms at the problem:** consider the most common data structures and how they would be applied to the problem at hand
	1) **hash maps:** efficient lookup.
	2) **graphs:** if the data is presented as associations between entities you might use a graph and graph algorithm to solve the problem.
	3) **stack** and **queue**: if you need to parse a string with nested properties (such as a mathematical equation) you will almost definitely need to use stacks.
	5) **heap:** questions involving scheduling/ordering based on some priority usually use heaps. 
	6) **tree/trie:** if you need to store strings in a space-efficient manner and look for the existence of strings (or a part of them) you use a trie. 
5) **apply common routines to the problem:** as for data structures you can consider known routines/approaches when reasoning about the solution: 
	1) **sorting**
	2) **binary search**
	3) **sliding window**
	4) **two pointers**
	5) **union find**
	6) **BFS/DFS**
	7) **traverse from the back**
	8) **topological sorting**
#### Optimize your solution
After you've come up with an initial solution to the problem your interviewer would most likely prompt you to optimize the solution by asking "can we do better?". 
**The following techniques aim to improve, if possible, the solution:** 
1) **identify the BTTC:** the BTTC (Best Theoretical Time Complexity) is the time complexity that you cannot beat. Finding the BTTC is crucial as you do not loose time trying to improve a solution that cannot be beaten. Remember that the BTTC is not necessarily achievable in practice. If your solution is already aligned with the BTTC you can improve the solution by:
	1) do less work, you can improve a constant 
	2) you can improve space complexity
2) **identify overlapping and repeated computation:** if you identify that a computation is repeated you can almost always apply Dynamic Programming. 
3) **identify redundant work:** these are not necessarily big mistakes but a clean and efficient code is highly considered by the interviewers: 
	1) `x < 5 && x < 10`: the first condition implies the second one, hence `x < 10` is useless. 
	2) `if likely() && unlikely()`: if we execute `unlikely()` first we do not have to execute `likely()`, hence improving performances.
	3) ...
4) **do not invoke methods unnecessarily:** if you have to refer to a property multiple times and that property is derived from a function call, cache the result as a variable (if the value of that property remains constant). As an example consider the length of an array: instead of invoking `array.length()` every time just use `int length = array.length()` once. 
5) **early termination:** stop after you already have the answer, return the result immediately.
6) **minimize work inside loops**
7) **be lazy:** lazy evaluation is an evaluation strategy which delays the evaluation of an expression until its value is needed. 
#### How to optimize space complexity
Most of the time time complexity is more important than space complexity. But when you have already reached the optimal time complexity, the interviewer might ask you to optimize the space of your solution. 
Here are some techniques to keep in mind: 
- **changing data in-place/overwriting input data:** If your solution contains code to create new data structures to do intermediate processing/caching, memory space is being allocated and can sometimes be seen as a negative. A trick to get around this is by overwriting values in the original input array so that you are not allocating any new space in your code. However, be careful not to destroy the input data in irreversible ways if you need to use it in subsequent parts of your code. A possible way which works (but you should never use outside of coding interviews) is to mutate the original array and use it as a hash table to store intermediate data. 
- **consider a different data structures**
### Behavioral Interview
**Companies don't want to hire brilliant jerks.**

Typically, behavioral interview questions can be split into several types:
1) getting to know your career preferences, ambitions and plans
2) discuss details of experiences or projects written in your resume
3) "tell me a time where you" type of questions where you describe how you demonstrated certain traits or responded to a situation
#### STAR Framework
The STAR framework help you organize the answers to behavioral questions, especially ones about previous experiences:
- **S**ituation: present a recent challenge you have faced
- **T**ask: what were you required to achieve? 
- **A**ction: what did you do? why? how were the alternatives?
- **R**esults: what was the outcome of your actions? what have you achieved and what you have learned?

**Example:**
"Tell me about a time in which you had a conflict and needed to influence somebody else".

**Situation:**
"I was the team lead of a school project about building a social network mobile web app. Our designer's midterms were approaching and didn't have time to produce the mockups. Our front-end person was rushing him for the mockups so that he could proceed with his work, and that was stressing the designer out. The atmosphere in the team was tense."

**Task:**
"As the team lead, I had to resolve the tension between the front-end developer and the designer so that the team could work together peacefully and complete the project on time."

**Action:**
"I spoke to the front-end developer to ask him why he was rushing the designer for the designs. He said that he wanted the designs early because it would be a waste of time rebuilding if the designer designed something different eventually. I explained to him that the midterm dates were out of the designer's control and we had to be more understanding about each other's schedules. I spoke to the designer to get a rough idea of what he had in mind and asked him when he could commit to producing the high-fidelity designs. He replied that he could start on them as soon as his midterms were over. I explained to him why the front-end developer was pushing him for the mockups, and that the front-end developer had no ill intentions and simply wanted the project to succeed. As someone with some experience in UI/UX design, I came up with wireframe mocks, ran them by the designer for approval, then passed them to the front-end developer to start building. I encouraged the front-end developer to use placeholders and not be too concerned about the details for now. We could build the non-UI parts first (authentication, hook up with APIs) and tweak pixels and add polish later on. The front-end developer agreed and went ahead with the approach. I explained to the front-end developer that the designer will pass us the mockups after his midterm, by *DATE*."​

**Result:**
"When our designer ended midterms, he came back with beautiful mockups that fit well into the wireframes. Our front-end developer implemented them with great care to detail. We ended up scoring top marks for the project and became a great team."
#### Commonly Asked Behavioral Questions
For more questions check [questions from other companies](https://www.techinterviewhandbook.org/behavioral-interview-questions/).

1. Why do you want to work for X company?
2. Why do you want to leave your current/last company?
3. What are you looking for in your next role?
4. Tell me about a time when you had a conflict with a co-worker.
5. Tell me about a time in which you had a conflict and needed to influence somebody else.
6. What project are you currently working on?
7. What is the most challenging aspect of your current project?
8. What was the most difficult bug that you fixed in the past 6 months?
9. How do you tackle challenges? Name a difficult challenge you faced while working on a project, how you overcame it, and what you learned.
10. What are you excited about?
11. What frustrates you?
12. Imagine it is your first day here at the company. What do you want to work on? What features would you improve on?
13. What are the most interesting projects you have worked on and how might they be relevant to this company's environment?
14. Tell me about a time you had a disagreement with your manager.
15. Talk about a project you are most passionate about, or one where you did your best work.
16. What does your best day of work look like?
17. What is something that you had to push for in your previous projects?
18. What is the most constructive feedback you have received in your career?
19. What is something you had to persevere at for multiple months?
20. Tell me about a time you met a tight deadline.
21. If this were your first annual review with our company, what would I be telling you right now?
22. Time management has become a necessary factor in productivity. Give an example of a time-management skill you've learned and applied at work.
23. Tell me about a problem you've had getting along with a work associate.
24. What aspects of your work are most often criticized?
25. How have you handled criticism of your work?
26. What strengths do you think are most important for _your job position_?
27. What words would your colleagues use to describe you?
28. What would you hope to achieve in the first six months after being hired?
29. Tell me why you will be a good fit for the position.

**AirBnb Questions**
While loving to travel or appreciating Airbnb's growth may be good answers, try to demonstrate the deep connection you have with the product.
- What does "belong anywhere" mean to you?
- What large problems in the world would you solve today?
- Why do you like Airbnb?
- If you had an unlimited budget and you could buy one gift for one person, what would you buy and who would you buy it for?
- If you had an unlimited budget and you could go somewhere, where would you go?
- Share one of your trips with us.
- What is the most challenging project in or out of school that you have worked on in the last 6 months.
- What is something that you don't want from your last internship/job?
- Give me an example of when you've been a good host.
- What's something you'd like to remove from the Airbnb experience?
- What is something new that you can teach your interviewer in a few minutes?
- Tell me about why you want to work here.
- What is the best gift you have ever given or received?
- Tell me about a time you were uncomfortable and how you dealt with it.
- Explain a project that you worked on recently.
- What do you think of Airbnb?
- Tell me something about yourself and why you'd be a good fit for the position.
- Name a situation where you were impressed by a company's customer service.
- How did you work with senior management on large projects as well as multiple internal teams?
- Tell me about a time you had to give someone terrible news.
- If you were a gerbil, which gerbil would you be?
- What excites you about the company?
- How does Airbnb impact our guests and hosts?
- What part of our mission resonates the most with you?

**Amazon Questions**
- How do you deal with a failed deadline?
- Why do you want to work for Amazon?
- Tell me about a situation where you had a conflict with a teammate.
- In your professional experience have you worked on something without getting approval from your manager?
- Tell me a situation where you would have done something differently from what you actually did.
- What is the most exceedingly bad misstep you've made at any point?
- Describe what Human Resources means to you.
- How would you improve Amazon's website?
#### If they believe you than it is the truth
As aforementioned, most top tech companies use their company values to evaluate candidates in behavioral interviews. As such, you should do your research to find out what those values are and ensure you have prepared experiences that showcase fit.
#### How Behavioral Interviews are evaluated
Each company evaluates differently, if you can try to speak with some employee and ask them for greater detail. 
**Some examples of common values evaluated are:**
- **motivation:** what drives you? you must be self-motivated, passionate, ...
	- "What project are you most proud of and why?"
	- "Tell me about a recent day working that was really great and/or fun."
- **ability to be proactive:** are you able to take initiative? given a difficult problem are you able to figure out how to get it done?
	- "Tell me about a time when you wanted to change something that was outside of your regular scope of work."
	- "Tell me about a time you had to make a fast decision and live with the results."
- **ability to work in an unstructured environment:** can you take ownership in ambiguous situations or do you rely on others to be told what to do?
	- "How do you decide what to work on next?"
	- "Tell me about a project or task that was ambiguous or under-specified."
- **perseverance:** are you able to push through difficult problems?
	- "Tell me about a time when you needed to overcome external obstacles to complete a task or project."
	- "Tell me about a time a project took longer as expected"
- **conflict resolution:** how well are you able to handle and work through challenging relationships?
	- "Tell me about a person or team who you found the most challenging to work with."
	- "Tell me about a time you disagreed with a coworker."
	- "Tell me about a situation where two teams couldn’t agree on a path forward."
	- **empathy:** how well you can "understand" others?
- **growth:** how well do you understand your strengths, weaknesses and growth areas? are you working on growing?
	- "Describe a situation when you made a mistake, and what you learned from it."
	- "Tell me about some constructive feedback you received from a manager or a peer."
	- "Tell me about a skill set that you observed in a peer or mentor that you want to develop in the next six months."
- **communication:** are you able to clearly communicate your stories during the interview?
## Technical Stuff
In the following we have a list of data structures and algorithms you should prepare for coding interviews: 
- **top priority:**
		- [[Array]]
		- string
		- hash table
		- tree
		- graph
		- matrix
	- **techniques:**
		- sorting
		- searching
- **mid priority:**
	- **data structures:**
		- recursion
		- linked list
		- queue
		- stack
		- heap
		- trie
		- interval
	- **techniques:**
		- greedy
- **low priority:**
	- **data structures:**
		- dynamic programming
		- binary
		- math
		- geometry
	- **techniques:**

### Interviews Problems Techniques Checklist 
**Note:** this is my checklist from my experience

**Arrays**
1) **is the array sorted?** 
	1) binary search, exponential search, or two pointers (starting from 0 and n-1)
2) **it is necessary to sort?** 
	1) when dealing with intervals $[s_i, e_i]$ almost always yes, either by $s_i$ or $e_i$
	2) not likely: sorting is very powerful and problems often becomes very easy once you sort.
3) **set** 
	1) you need to check the presence of something?
4) **hash map**
	1) presence of stuff
	2) occurrence of stuff
	3) where stuff happens (store the index where ...)
5) **two pointers**
	1) they usually work when the array is sorted
	2) left = 0, right = n-1
	3) middle = n/2, left = middle-1, right = middle+1
	4) **sliding window**
		1) use two pointers to make the start and end of the window
		2) might need a data structure to implement the window (list, deque, ..)
		3) usually with subarray / substring
