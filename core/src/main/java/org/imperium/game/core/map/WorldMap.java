package org.imperium.game.core.map;

import dto.CellDto;

import java.util.List;

public record WorldMap(int mapWidth, int mapHeight, int cellSize, List<CellDto> cells) {
}
