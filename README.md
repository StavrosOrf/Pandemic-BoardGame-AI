# PLH517_Project
Designing the players of the Pandemic Board-Game with a multi-agent cooperative theory approach.

# Strategy
Through experimentation we came up with an agent that can adapt depending on the rest of the player's strategies.
The way our agent works is through a set of utility functions that search and evaluate action sequences for each
round (a total depth of 4 moves). The weight of the utility that is given to the actions themselves has been decided
after meticulous testing(manual batch learning). After deciding on the best action sequence, the agent looks at
the suggestions the rest of the players give us for two reasons. Firstly, through those suggestions we can create a
high level impression of that agent's strategy(policy re-constructions), and use it to make a model of that opponent.
Secondly, if an opponent suggests a move that is out of character for him, we assume he has a serious reason to do so,
and therefore give his suggestion increased weight. We then compare the utility of the suggestions with the action
sequence we found to be best ourselves, and we follow the one that scores better. Finally, after each round, we adjust
the weights we attribute to each kind of action depending on the opponent modeling we have made for the other
players, so that we better complement their way of playing. For example, if the other players almost never build
research stations, we will increase the importance of building them for ourselves, since if no one ever built them the
game wouldn't be balanced. By maintaining this balance we nd that we can achieve an acceptable win/loss ratio.
It is also worth noting that as the game progresses the models we have created for our opponents become more and
more reliable.

For more details read the report.pdf
