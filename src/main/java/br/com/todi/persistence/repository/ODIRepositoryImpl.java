package br.com.todi.persistence.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.CenarioODI;
import br.com.todi.model.Projeto;
import br.com.todi.model.RepositorioInfo;

@Component
public class ODIRepositoryImpl implements ODIRepository {

	@Override
	public List<CenarioODI> buscarCenariosODI(Projeto projeto) {
		List<CenarioODI> cenariosODI = new ArrayList<CenarioODI>();
		// Pegar conexão para o repositório do projeto
		Connection con = this.getODIWorkRepositoryConnection(projeto);
		if (con != null) {
			String sql = " select scen_name as CENARIO, scen_version as VERSAO, scen_no as ID_ODI " +
						 " from snp_scen where (scen_name, scen_version) in ("+
                                   " select scen_name, max(scen_version) " +
                                   " from snp_scen " +
                                   " group by scen_name )";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String cenario = rs.getString("CENARIO");
					String versao = rs.getString("VERSAO");
					Long idOdi = rs.getLong("ID_ODI");
				
					cenariosODI.add(new CenarioODI(cenario, versao, idOdi));
				}
				return cenariosODI;
			} catch (SQLException e) {
				return null;
			}
			
		}
		return null;
	}
	
	private Connection getODIMasterRepositoryConnection(Projeto projeto) {
		Connection con = null;
		RepositorioInfo repoInfo = projeto.getRepositorioInfo();
		String driver = repoInfo.getLoginDBDriver();
		String url = repoInfo.getLoginDBURL();
		String user = repoInfo.getLoginDBUser();
		String password = repoInfo.getLoginDBPass();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private Connection getODIWorkRepositoryConnection(Projeto projeto) {
		Connection con = null;
		RepositorioInfo repoInfo = projeto.getRepositorioInfo();
		String driver = repoInfo.getLoginDBDriver();
		String url = repoInfo.getLoginDBURL();
		String user = repoInfo.getLoginWorkUser();
		String password = repoInfo.getLoginWorkPass();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	
}
