# Multi-Threading Prototype/Practice

The main purpose of this prototype is to test a concept for a game I am currently developing in Java.\
Some things to note:
- The number of active `Action` threads needs to be kept track of in order to properly await the correct number of times.
  - Furthermore, I need to figure out a way to keep the await number dynamic so that the CyclicBarrier is accurate at all times and doesn't force a funky loop.
- I think this version of the `Action` class will work to generate new Threads as I need them, I will need to add some more code in order to actually start the Threads and process some extra logic, but it should work fine, there shouldn't be any race conditions with the addition of the CyclicBarrier
- Now that I am thinking of a solution, I wonder if it would be a good idea to run `reset()` every time an `Action` thread terminates. I'll have to do some testing to figure out the behavior of `reset()`, as it may not do what I am thinking. I will probably instead just rebuild the `CyclicBarrier` with a flag at the start of every turn.
  - `if(ACTION_TERMINATED){/*rebuild CyclicBarrier*/}`
  - Something like this ^

This was an interesting exercise and has definitely helped in fixing an issue I was having with `Actions` in my game. I bet this will also help me in the future with different features.

Something else this prototype has got me thinking about, how does *Minecraft* process its mob AI? It would be inefficient to do them all on separate Threads, so how do they do it? This will be something I research in the future as it may become something I implement myself if I can figure out their strategy for processing mob AI.