package pocman;

import java.util.*;

public class Qlearn {
	public double epsilon = 0.2; // parametre epsilon pour \epsilon-greedy
	public double alpha = 0.2; // taux d'apprentissage
	public double gamma = 0.9; // parametre gamma des eq. de Bellman/
	
	// Suggestions
	public int actions[];
	public Hashtable< Tuple<Integer,Integer>, Double> q;
	Random random = new Random(1265);
	
	// Constructeurs
	public Qlearn(int[] actions) {
		this.actions = actions;
		q = new Hashtable<>();
	}
	
	public Qlearn(int[] actions, double epsilon, double alpha, double gamma) {
		this(actions);
		this.epsilon = epsilon;
		this.alpha = alpha;
		this.gamma = gamma;
	}


	public Tuple<Integer, Double> bestAction(int state){


	    int bestActIndex = -1;
	    double actionProb = -1e10;

        for (int action : this.actions){
            double qAct = this.q.getOrDefault(new Tuple<>(state, action), .0);
            //System.out.print(qAct + " ");
            if (qAct >= actionProb){
                actionProb = qAct;
                bestActIndex = action;
            }
        }

        //System.out.print("\nbest act : " + Pacman.getAction(bestActIndex) + ", value : " + actionProb + "\n\n");

        return new Tuple<>(bestActIndex, actionProb);

    }

	public int ChooseAction(int state){

		if (random.nextDouble() < this.epsilon) {
			 return this.actions[bestAction(state).x];
		} 
		else {
			return this.actions[random.nextInt(actions.length)];
		}
	}
	
	public void learn(int st, int at, int st1, double r){
		Tuple <Integer,Integer> t = new Tuple<>(st, at);
		double ql = (1-this.alpha)*this.q.getOrDefault(t, 0d) + this.alpha * (r + this.gamma*bestAction(st1).y);

//        System.out.print("Q(t)" + this.q.get(t) + " - ");
//        System.out.print("Q(t+1)" + ql + "\n");

        this.q.put(t, ql);
	}
	
	public void sarsa(int st, int at, int st1, int at1, double r1){
		Tuple <Integer,Integer> t1 = new Tuple<>(st1, at1);
		Tuple <Integer,Integer> t = new Tuple<>(st, at);
		double ql = this.q.getOrDefault(t, 0d)
                + this.alpha * (r1 + this.gamma*this.q.getOrDefault(t1, 0d) - this.q.getOrDefault(t, 0d));
		q.put(t, ql); 
	}
}
