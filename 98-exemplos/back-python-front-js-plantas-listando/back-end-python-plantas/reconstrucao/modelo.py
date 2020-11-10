from config import *

class Planta(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    nome_cientifico = db.Column(db.String(254))
    tamanho_folha = db.Column(db.String(254))
    periodo_poda = db.Column(db.Integer) # em dias
    def __str__(self):
        return str(self.id) + "," + self.nome + ", " + self.nome_cientifico + ", " + \
               self.tamanho_folha + ", " + str(self.periodo_poda)
    def json(self):
        return {
            "id" : self.id,
            "nome" : self.nome,
            "nome_cientifico" : self.nome_cientifico,
            "tamanho_folha" : self.tamanho_folha,
            "periodo_poda" : self.periodo_poda
        }

if __name__ == "__main__":

    if os.path.exists(arquivobd):
        os.remove(arquivobd)

    db.create_all()

    nova = Planta(nome = "hortelã", nome_cientifico = "Mentha Spicata",
                tamanho_folha = "pequena", periodo_poda = "60")
    db.session.add(nova)
    db.session.commit()
    todas = db.session.query(Planta).all()
    for p in todas:
        print(p)
        print(p.json())
    # print(nova.nome)