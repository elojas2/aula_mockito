package jogo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JogoTest {

	private Jogador jogador;
	private Dado dadinho1;
	private Dado dadinho2;
	private Jogo jogo;

	@BeforeEach
	public void setUp() {
		jogador = mock(Jogador.class);
		dadinho1 = mock(Dado.class);
		dadinho2 = mock(Dado.class);
		jogo = new Jogo(jogador, dadinho1, dadinho2);
	}

	@Test
	public void deveGanharNoPrimeiroTurnoComSete() {
		when(jogador.lancar(any(Dado.class), any(Dado.class))).thenReturn(7);

		assertTrue(jogo.jogo());
		verify(jogador, times(1)).lancar(dadinho1, dadinho2);
	}

	@Test
	public void deveGanharNoPrimeiroTurnoComOnze() {
		when(jogador.lancar(any(Dado.class), any(Dado.class))).thenReturn(11);

		assertTrue(jogo.jogo());
	}

	@Test
	public void devePerderNoPrimeiroTurnoComDois() {
		when(jogador.lancar(any(Dado.class), any(Dado.class))).thenReturn(2);

		assertFalse(jogo.jogo());
	}
}
