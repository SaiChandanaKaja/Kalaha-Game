
package ai;
import kalaha.GameState;

/**
 *
 */
public class Myminimax 
{
    
    int k;
    
    /* The class Initiate_Minimax initiates the Minimax Algorithmn
    */
    
    public int Initiate_Minimax(GameState state, int depth_key)
    { 
        int Last_move=0;       
        return Last_move=max(state,depth_key,-20000,20000);
    }
    
    /*The utility function for the 
        minimax algorithm*/
    
    public int utility(GameState s)
    {
        if(s.getNextPlayer() == 1) {
           return s.getScore(1) - s.getScore(2); }
        else {
        return s.getScore(2) - s.getScore(1);
        }
     }
    
    /*Function for max initiates here */
    
    public int max (GameState state, int depth_key,int alpha_Value, int beta_Value)
    {
        int l=Integer.MIN_VALUE,Last_move=0;
       
        int i;
        
        depth_key++;
        if(depth_key==1)
        {
               for(i=1;i<7;i++)
               {
                    int tmp=0;
                    GameState duplicate_board = (GameState)state.clone();
                    if(duplicate_board.moveIsPossible(i)) 
                    {
                    
                        duplicate_board.makeMove(i);
                    
                        tmp=min(duplicate_board,depth_key,alpha_Value,beta_Value);
                        /*Finds the MAX(min(s,depth_key,alpha_Value,beta_Value)*/
                        if(l<=tmp)
                        {
                            l=tmp;
                            Last_move=i;
                        }
                    }
                    /*alpha_Value beta_Value pruning initiates here*/
                    if(l>=beta_Value)
                    {
                        return Last_move;
                    }
                    if(alpha_Value<l)
                        alpha_Value=l;        
                }
               return Last_move;   // The Last_move to be returned to the method getMove().
        }
        
        /*14 is set as the maximum depth_key */
        if(depth_key<14&&depth_key!=1)
        {
            for(i=1;i<7;i++)
            {
                int tmp=0;
                GameState duplicate_board = (GameState)state.clone();
                if(duplicate_board.moveIsPossible(i))
                {
                    
                    duplicate_board.makeMove(i);
                    
                    tmp=min(duplicate_board,depth_key,alpha_Value,beta_Value);
                    /*This statement is to search 
                        MAX(min(s,depth_key,aplha,beta_Value))*/
                    if(l<=tmp)
                    {
                        l=tmp;
                    }
                }
                /*alpha_Value beta_Value pruning*/
                if(l>=beta_Value)
                    return l;
                if(alpha_Value<l)
                    alpha_Value=l;
            }
            return l;
        }
        return 0;
    }
    
    public int min(GameState state,int depth_key,int alpha_Value, int beta_Value)
    {
        
        int i,min_value,l=Integer.MAX_VALUE;
        depth_key++;
        
        if(depth_key==14)
        {
            
           return min_value=utility(state);
        }
        
        if(depth_key<14)
        {
            for(i=1;i<7;i++)
            {
                int temp=0;
                GameState s2 = (GameState)state.clone();
                if(s2.moveIsPossible(i))
                {
                    s2.makeMove(i);
                       temp=max(s2,depth_key,alpha_Value,beta_Value);
                       /*code for MIN(max(s,depth_key,alpha_Value,beta_Value))*/ 
                       if(l>=temp)
                        {
                            l=temp;
                        }
                }
                /*alpha_Value beta_Value pruning*/
                if(l<=alpha_Value)
                    return l;
                if(l<beta_Value)
                    beta_Value=l;
            }    
            return l;
            
        }
       return 0; 
    }
}