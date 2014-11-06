/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.statful;

/**
 *
 * @author adam
 * @param <S> Obiekt może posiadać tylko określone stany, dziedziczące po
 * (S)tate
 */
public abstract class AbstractStateful<S extends AbstractState> {

    @SuppressWarnings("LeakingThisInConstructor")
    public AbstractStateful(S initialState) {
        state = initialState;
        initialState.onEnterState(this);
    }
    private S state;

    public S getState() {
        return state;
    }

    public final boolean setState(S newState) {
        if (state.canChangeState(newState)) {
            state.onExitState(this);
            state = newState;
            newState.onEnterState(this);
            return true;
        }
        return false;
    }

}
