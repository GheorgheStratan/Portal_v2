package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SelectWindow extends BasicGameState {
	private Music music;
	
	private Image logo_destra;
	private Image logo_sinistra;
	private Image logoNamePortal;
	private Image logoName2D;
	private float yLogo = 100;
	private float y1 = 20;
	private float y2 = 20;
	private boolean scambio = false;
	private ListaBottoni buttons;
	private boolean mouseM;
	private Image background;
	private Sound scroll;
	private Sound select;
	private int indice = -1;
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		logoNamePortal = new Image("images/SelectWindow/Logo/Portal_nome.png");
		logoName2D = new Image("images/SelectWindow/Logo/2D.png");
		logo_destra = new Image("images/SelectWindow/Logo/Porta LOGO_1.png");
		logo_sinistra = new Image("images/SelectWindow/Logo/Porta LOGO_2.png");
		buttons = new ListaBottoni();

		/* NOTA BENE L'ID DEGLI STATI */
		buttons.addElement(new Buttons(new Image("images/SelectWindow/Buttons/NewGameButtonBlue.png"),
				new Image("images/SelectWindow/Buttons/NewGameButtonOrange.png"), 2), new Coordinate(394, 350));
		buttons.addElement(
				new Buttons(new Image("images/SelectWindow/Buttons/LoadGameButtonBlue.png"),
						new Image("images/SelectWindow/Buttons/LoadGameButtonOrange.png"), 3),
				new Coordinate(389, 420));
		buttons.addElement(
				new Buttons(new Image("images/SelectWindow/Buttons/SpeedRunButtonBlue.png"),
						new Image("images/SelectWindow/Buttons/SpeedRunButtonOrange.png"), 4),
				new Coordinate(394, 490));
		buttons.addElement(new Buttons(new Image("images/SelectWindow/Buttons/OptionsButtonBlue.png"),
				new Image("images/SelectWindow/Buttons/OptionsButtonOrange.png"), 5), new Coordinate(409, 560));
		buttons.addElement(new Buttons(new Image("images/SelectWindow/Buttons/CreditsButtonBlue.png"),
				new Image("images/SelectWindow/Buttons/CreditsButtonOrange.png"), 6), new Coordinate(409, 630));
		background = new Image("images/SelectWindow/Back.png");
		
		music=new Music("Sound/SelectWindow/audio1.ogg");
		music.loop();

		scroll = new Sound("Sound/SelectWindow/GUI_Scroll Sound 17 1.ogg");
		select = new Sound("Sound/SelectWindow/GUI_Select_02 1.ogg");
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		/*
		 * Immetto all'interno di 2 variabili posXini,posYini la posizione del mouse
		 * all'inizio
		 */
		container.getInput().addMouseListener(this);
		if (yLogo > 85 && !scambio) {
			y1 -= 0.03 * delta;
			y2 -= 0.03 * delta;
			yLogo -= 0.03 * delta;
		} else if (yLogo < 115) {
			scambio = true;
			y1 += 0.03 * delta;
			y2 += 0.03 * delta;
			yLogo += 0.03 * delta;
		} else {
			scambio = false;
		}

		/*
		 * In questo ciclo controllo se all'elemento i-esimo dell'array list di bottoni
		 * bisogna settagli lo stato interno a true(NB: settare lo stato interno
		 * significa mostrare la seconda immagine). Questo avviene SOLO se l'utente
		 * preme con il tasto sinistro del mouse sulla scritta
		 */
		if (mouseM) {
			for (int i = 0; i < buttons.bottoni.size(); i++) {
				if (container.getInput().getAbsoluteMouseX() >= buttons.coordinate.get(i).getX()
						&& container.getInput()
								.getAbsoluteMouseX() <= (buttons.coordinate.get(i).getX()
										+ buttons.bottoni.get(i).getIniziale().getWidth())
						&& container.getInput().getAbsoluteMouseY() >= buttons.coordinate.get(i).getY()
						&& container.getInput().getAbsoluteMouseY() <= (buttons.coordinate.get(i).getY()
								+ buttons.bottoni.get(i).getIniziale().getHeight())) {
					buttons.bottoni.get(i).setStato(true);
				} else {
					if (indice == i)
						indice = -1;
					buttons.bottoni.get(i).setStato(false);
				}
			}
		} else {
			/*
			 * Controllo se sono mai state utilizzate le freccie UP and DOWN, ovvero se
			 * almeno uno stato di uno dei buttons e' stato modificato. Se nessuno è mai
			 * stato modificato allo mi posiziono su New Game, altrimenti in base ad UP e
			 * DOWN si sposta al precedente o successivo
			 */
			boolean trovato = false;
			int j = 0; /*
						 * Variabile utilizzata per contenere quale bottone e' attualmente selezionato
						 */
			for (int i = 0; i < buttons.bottoni.size(); i++)
				if (buttons.bottoni.get(i).isStato() == true) {
					j = i;
					trovato = true;
				}
			/* Mi chiedo se è stato premuto il tasto UP */
			if (container.getInput().isKeyPressed(Input.KEY_UP)) {
				if (trovato == false) {
					/* Si accede SOLO nel caso che NON si è MAI utilizzato le freccie UP and DOWN */
					buttons.bottoni.get(j).setStato(true);
				} else {
					/* Analizzo quale bottone e' attualmente selezionato */
					buttons.bottoni.get(j).setStato(false);
					if (j == 0)
						buttons.bottoni.get(buttons.bottoni.size() - 1).setStato(true);
					else
						buttons.bottoni.get(j - 1).setStato(true);
				}
			}
			if (container.getInput().isKeyPressed(Input.KEY_DOWN)) {
				if (trovato == false) {
					/* Si accede SOLO nel caso che NON si è MAI utilizzato le freccie UP and DOWN */
					buttons.bottoni.get(j).setStato(true);
				} else {
					/* Analizzo quale bottone e' attualmente selezionato */
					buttons.bottoni.get(j).setStato(false);
					if (j == buttons.bottoni.size() - 1)
						buttons.bottoni.get(0).setStato(true);
					else
						buttons.bottoni.get(j + 1).setStato(true);
				}
			}
		}

		for (int i = 0; i < buttons.bottoni.size(); i++)
			if (buttons.bottoni.get(i).isStato() && indice != i)
				scroll.play();

		/* Eseguo i controlli per cambiare lo stato del programma */
		/* MAN MANO CHE SI CREANO LE VARIE PARTI VERRANO COLLEGATE AI RELATIVI ID */
		for (int i = 0; i < buttons.bottoni.size(); i++) {
			if (buttons.bottoni.get(i).isStato() == true
					&& (container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)
							|| container.getInput().isKeyPressed(Input.KEY_ENTER)))
				// state.enterState(buttons.bottoni.get(i).getID());
				if (buttons.bottoni.get(0).isStato() == true) {
					select.play();
					state.enterState(buttons.bottoni.get(0).getID());
				}
		}
		if (mouseM == true)
			mouseM = false;
	}

	/*
	 * Eseguo un override di mouseMoved nel quale se le coordinate iniziali e finali
	 * sonon differenti allora mouseMoved viene posto a false altrimenti viene posto
	 * a true
	 */
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		if (oldx != newx || oldy != newy)
			mouseM = true;
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		background.draw(0, 0, 1024, 800);
		logoNamePortal.draw(240, yLogo, 1.3f);
		logoName2D.draw(660, yLogo, 1.3f);
		logo_destra.draw(810, y1, 0.6f);
		logo_sinistra.draw(85, y2, 0.6f);
		for (int i = 0; i < buttons.bottoni.size(); i++) {
			if (buttons.bottoni.get(i).isStato() == false)
				buttons.bottoni.get(i).getIniziale().draw(buttons.coordinate.get(i).getX(),
						buttons.coordinate.get(i).getY());
			else {
				buttons.bottoni.get(i).getFinale().draw(buttons.coordinate.get(i).getX(),
						buttons.coordinate.get(i).getY());
				indice = i;
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
