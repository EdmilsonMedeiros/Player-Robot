package Tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import PR_Musica.Musica;
import PR_Musica.PlayList;

public class Modelo_PlayList extends AbstractTableModel{
	
	private ArrayList<Musica> playlist;
	private String[] nomeColunas = 
	{
			"Nome",
			"Artista",
			"Album"
	};
	
	public Modelo_PlayList() 
	{
		this.playlist = new ArrayList<Musica>();
	}
	
	public Modelo_PlayList(ArrayList<Musica> playlist) 
	{
		this.playlist = playlist;
	}
	
		
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nomeColunas.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.playlist.size();
	}
	
	@Override
    public String getColumnName(int column)
    {
        return nomeColunas[column];
    }
	@Override
	public Class getColumnClass(int column)
	{
	    switch (column)
	    {
	        case 2: return String.class;
	        default: return String.class;
	    }
	}
	@Override
	public boolean isCellEditable(int row, int column)
	{
	    switch (column)
	    {
	        case 2: return false; // only the birth date is editable
	        default: return false;
	    }
	}
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Musica ms = getMusica(row);
		
		switch(column) 
		{
		case 0: return ms.getNome();
		case 1: return ms.getCompositor().getNome();
		case 2: return ms.getCategoria().getDescricao();
		default: return null;
		}
	}
	
	@Override
	public void setValueAt(Object value, int row, int column)
	{
		Musica ms = getMusica(row);
		Musica mm = (Musica) value;
	    switch (column)
	    {
	    case 0: ms.setNome(mm.getNome()); break;
		case 1: ms.setCompositor(mm.getCompositor()); break;
		case 2: ms.setCategoria(mm.getCategoria()); break;
		
	    }
	 
	    fireTableCellUpdated(row, column);
	}
	
	public Musica getMusica(int row)
	{
	    return playlist.get( row );
	}
	
	public void addMusica(Musica musica)
	{
	    insertPerson(getRowCount(), musica);
	}
	 
	public void insertPerson(int row, Musica musica)
	{
	    playlist.add(row, musica);
	    fireTableRowsInserted(row, row);
	}
	
	public void removePerson(int row)
	{
		playlist.remove(row);
	    fireTableRowsDeleted(row, row);
	}
	
	
}