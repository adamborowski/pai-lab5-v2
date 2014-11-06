/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.statful;

/**
 *
 * @author adam
 * @param <S> typy innych stanów, które są w ramach jednego stateful
 */
public abstract class AbstractState<S extends AbstractState> {

    /**
     * Sprawdza, czy można opuścić dany stan i przejść do innego
     *
     * @param nextState
     * @return
     */
    public boolean canChangeState(S nextState) {
        return true;
    }

    /**
     * Wołane przez stateful w momencie wejścia do stanu
     *
     * @param stateful
     */
    public void onEnterState(AbstractStateful<S> stateful) {

    }

    /**
     * Wołane przez stateful w momencie wyjścia ze stanu
     *
     * @param stateful
     */
    public void onExitState(AbstractStateful<S> stateful) {

    }
}
